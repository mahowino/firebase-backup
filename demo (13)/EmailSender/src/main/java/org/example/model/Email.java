package org.example.model;


import lombok.Builder;

@Builder
public class Email {

    String content;
    String subject;
    public String getContent() {
       return content;
    }

    public void setContent(StringBuilder pendingContent){
        content= pendingContent.toString();

    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject=subject;
    }

}
