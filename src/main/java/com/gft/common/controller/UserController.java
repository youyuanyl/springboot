package com.gft.common.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gft.app.domain.AqMenu;
import com.gft.app.domain.AqUser;
import com.gft.app.service.SysService;
import com.gft.app.service.UserService;
import com.gft.common.utils.Tools;

@Controller
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SysService sysService;
	
	
	@RequestMapping("/toLogin.do")
	public String toLogin(HttpServletRequest request, String issuccess){
		System.out.println("跳转登录");
		request.setAttribute("issuccess", issuccess);
		System.out.println(issuccess);
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, AqUser user){
		System.out.println("登录");
		String issuccess = "login_1";
		String sessionCheckCode = (String) request.getSession().getAttribute("CheckCode");
		if(StringUtils.isBlank(sessionCheckCode)){
			issuccess = "login_2";
			return "redirect:/toLogin.do?issuccess=" + issuccess;
		}
		
		String checkcode = user.getCheckcode();
		if(StringUtils.isNotBlank(checkcode)) checkcode = checkcode.toUpperCase();
		if(!sessionCheckCode.equals(checkcode)){
			issuccess = "login_3";
			return "redirect:/toLogin.do?issuccess=" + issuccess;
		}
		
		AqUser loginUser = userService.getUser(user);
		if(null != loginUser){
			request.getSession().setAttribute("LOGIN_USER", loginUser);
			return "redirect:/successLogin.do";
		}else{
			issuccess = "login_4";
		}
		return "redirect:/toLogin.do?issuccess=" + issuccess;
	}
	
	
	@RequestMapping("/listUser.do")
	public String listUser(HttpServletRequest request){
		System.out.println("登录成功！");
		List<AqUser> userList = userService.select();
		request.setAttribute("userList", userList);
		return "sys/listUser";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("LOGIN_USER");
		return "login";
	}
	
	@RequestMapping("/toRegister.do")
	public String toRegister(HttpServletRequest request){
		
		return "register";
	}
	
	@RequestMapping("/register.do")
	public String register(HttpServletRequest request, AqUser user){
		try {
			user.setId(Tools.getUUID());
			userService.insert(user);
			return "redirect:/toLogin.do?issuccess=register_1";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("issuccess", "register_2");
			return "register";
		}
	}
	
	@RequestMapping("/loginCheckImage.do")
	public String LoginCheckImage(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("image/jpeg");
		response.addHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Cache-Control", "pre-check=0,post-check=0");
		response.setDateHeader("Expires", 0);
		String checkstr = Tools.getCheckCode(4, false);
		HttpSession session = request.getSession();
		session.setAttribute("CheckCode", checkstr);
		
		int width = 40;
		int height = 16;
		BufferedImage bufimage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		Graphics grp = null;
		try {
			grp = bufimage.getGraphics();
			grp.setColor(new Color(255, 000, 255));
			grp.setFont(new Font("Verdana", Font.BOLD, 12));
			grp.setColor(new Color(0xDDDD22));
			grp.fillRect(0, 0, width, height);

			grp.setColor(Color.blue);
			grp.drawRect(0, 0, width - 1, height - 1);

                grp.drawString(checkstr, 2, 13);
              }catch(Exception ee){
            	  ee.printStackTrace();
              }finally{grp.dispose() ;}

              ServletOutputStream sos = null;
		try {
			sos = response.getOutputStream();
			ImageIO.write(bufimage, "JPEG", sos);
			sos.close();
		} catch (Exception e) {
			try {
				sos.close();
			} catch (Exception eee) {
				eee.printStackTrace();
			}
		}
		return null;
	}
}
