package org.example.repository;

public class EmailTemplates {
    public static StringBuilder getSurveyEmail() {
        StringBuilder emailBuilder=new StringBuilder();emailBuilder.append("<html><body>");
        emailBuilder.append("<p style=\"margin:0cm;font-size:11pt;font-family:Calibri,sans-serif;text-align:justify;color:rgb(36,36,36);background-color:rgb(255,255,255)\">");
        emailBuilder.append("<span style=\"font-family:&quot;Gill Sans MT&quot;,sans-serif;margin:0px\">");
        emailBuilder.append("Dear Member,<br></span></p><br>");
        emailBuilder.append("<p style=\"margin:0cm;font-size:11pt;font-family:Calibri,sans-serif;text-align:justify;color:rgb(36,36,36);background-color:rgb(255,255,255)\">");
        emailBuilder.append("<span style=\"font-family:&quot;Gill Sans MT&quot;,sans-serif;margin:0px\">");
        emailBuilder.append("We trust this message finds you well. As a member of the NSE &amp; CDSC Staff Provident Fund, we highly value your opinions and feedback. Your feedback plays a crucial role in helping the Trustees understand your needs and preferences, enabling us to continually improve services. The survey will only take five minutes of your time, but the insights we gain will be immensely valuable in shaping the future of our pension scheme.</span></p><br>");
        emailBuilder.append("<p style=\"margin:0cm;font-size:11pt;font-family:Calibri,sans-serif;text-align:justify;color:rgb(36,36,36);background-color:rgb(255,255,255)\">");
        emailBuilder.append("<span style=\"font-family:&quot;Gill Sans MT&quot;,sans-serif;margin:0px\">");
        emailBuilder.append("That is why we would like to invite you to participate in our annual Pension Scheme Survey. To access the survey, please click on the following link: <a href=\"https://forms.gle/MdXet4qYTQytCHp47\">https://forms.gle/MdXet4qYTQytCHp47</a>. The deadline for completing the survey is 15th June 2023.</span></p><br>");
        emailBuilder.append("<p style=\"margin:0cm;font-size:11pt;font-family:Calibri,sans-serif;text-align:justify;color:rgb(36,36,36);background-color:rgb(255,255,255)\">");
        emailBuilder.append("<span style=\"font-family:&quot;Gill Sans MT&quot;,sans-serif;margin:0px\">");
        emailBuilder.append("Thank you in advance for your valuable input. Should you have any questions or concerns regarding the survey, please don't hesitate to contact our dedicated relationship management team at CPF, Michelle Nyandiko <a href=\"mailto:mnyandiko@cpf.or.ke\">mnyandiko@cpf.or.ke</a> or Linda Kemboi <a href=\"mailto:lkemboi@cpf.or.ke\">lkemboi@cpf.or.ke</a></span></p><br>");
        emailBuilder.append("<p style=\"margin:0cm;font-size:11pt;font-family:Calibri,sans-serif;text-align:justify;color:rgb(36,36,36);background-color:rgb(255,255,255)\">");
        emailBuilder.append("<span style=\"font-family:&quot;Gill Sans MT&quot;,sans-serif;margin:0px\">");
        emailBuilder.append("Best regards,</span></p><br>");
        emailBuilder.append("<p style=\"margin:0cm;font-size:11pt;font-family:Calibri,sans-serif;text-align:justify;color:rgb(36,36,36);background-color:rgb(255,255,255)\">");
        emailBuilder.append("<span style=\"font-family:&quot;Gill Sans MT&quot;,sans-serif;margin:0px\">");
        emailBuilder.append("Mitchelle Nyandiko<br>Pension Services Manager, CPF Financial Services</span></p><br>");
        emailBuilder.append("</body></html>");

        return emailBuilder;
    }
}
