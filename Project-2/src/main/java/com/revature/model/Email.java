package com.revature.model;

public class Email {
	
	final private String FROM = "erinadduncan@gmail.com";
	final private String FROMNAME = "Spot!";

	private String to;
	// Replace smtp_username with your Amazon SES SMTP user name.
	final private String SMTP_USERNAME = "AKIA3KWGH5S47N6UIFHL";
	// Replace smtp_password with your Amazon SES SMTP password.
	private final String SMTP_PASSWORD = "BP+a2QGl784d30bIYe3colS+ifUT29bDctstJyXnjQBR";
	// The name of the Configuration Set to use for this message.
	// If you comment out or remove this variable, you will also need to
	// comment out or remove the header below.
//		    static final String CONFIGSET = "ConfigSet";
	// Amazon SES SMTP host name. This example uses the US West (Oregon) region.
	// See
	// https://docs.aws.amazon.com/ses/latest/DeveloperGuide/regions.html#region-endpoints
	// for more information.
	private final String HOST = "email-smtp.us-east-1.amazonaws.com";
	// The port you will connect to on the Amazon SES SMTP endpoint.
	private final int PORT = 8080;
	private final String SUBJECT = "Pasword Reset";
	// TODO: fix this
	
	String linkIp = "";
	
	private final String BODY = String.join(System.getProperty("line.separator"), "<h1>Password Reset</h1>",
			"<p>This email was sent with Amazon SES using the </p>",
			"<a href='http://localhost:3000/resetpassword'>Javamail Package</a>");
	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getLinkIp() {
		return linkIp;
	}

	public String getFROM() {
		return FROM;
	}

	public String getFROMNAME() {
		return FROMNAME;
	}

	public String getSMTP_USERNAME() {
		return SMTP_USERNAME;
	}

	public String getSMTP_PASSWORD() {
		return SMTP_PASSWORD;
	}

	public String getHOST() {
		return HOST;
	}

	public int getPORT() {
		return PORT;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public String getBODY() {
		return BODY;
	}
	
	public Email() {
		super();
	}

	public Email(String to) {
		super();
		this.to = to;
	}


}
