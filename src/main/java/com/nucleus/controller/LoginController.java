package com.nucleus.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nucleus.dao.UserDao;
import com.nucleus.entity.Users;

@Controller
public class LoginController {

	@Autowired
	UserDao userDao;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	JobRegistry jobRegistry;

	@RequestMapping("/login")
	public String login() {
		System.out.println("Login");
		return "login";
	}

	@Transactional
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute Users user) {
		System.out.println(user);
		userDao.save(user);
		return "success";
	}

	@RequestMapping(value = "/target")
	public String target() {
		return "target";
	}

	@RequestMapping(value = "/failure")
	public String failure() {
		System.out.println("Failure");
		return "failure";
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String fileupload(@RequestParam("file") MultipartFile file) throws IOException {
		String paths = "D:\\Upload\\";
		File fileToImport = new File(paths + file.getOriginalFilename());
		System.out.println(" :::::::::::::::::::  File name is ::---------------------------" + fileToImport);
		OutputStream outputStream = new FileOutputStream(fileToImport);
		IOUtils.copy(file.getInputStream(), outputStream);
		outputStream.flush();
		try {
			outputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			JobExecution jobExecution = jobLauncher.run(jobRegistry.getJob("loanUpload"),
					new JobParametersBuilder().addString("file", fileToImport.getAbsolutePath()).toJobParameters());
			System.out.println(jobExecution);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			System.out.println("Duplicate File");
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchJobException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
}
