package org.example.service.utils;

public enum Paths {
    DEVELOPMENT_PATH,
    PRODUCTION_PATH;

    @Override
    public String toString() {
        switch (this) {
            case DEVELOPMENT_PATH:
                return "C:\\Users\\USER\\Downloads\\demo (13)\\EmailSender\\src\\main\\java\\org\\example\\emailsDev.csv";
            case PRODUCTION_PATH:
                return "C:\\Users\\USER\\Downloads\\demo (13)\\EmailSender\\src\\main\\java\\org\\example\\emails.csv";
            default:
                return super.toString();
        }
    }
}
