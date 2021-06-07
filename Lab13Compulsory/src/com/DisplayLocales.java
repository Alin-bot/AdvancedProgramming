package com;

public static void displayLocales(Locale locale) {
        String baseName = "com.example.MyResources";
        ResourceBundle messages =
        ResourceBundle.getBundle(baseName, locale);
        System.out.println(messages.getString("hello"));
        String pattern = messages.getString("welcome");
        Object[] arguments = {"Duke", LocalDate.now()};
        String welcome = new MessageFormat(pattern).format(arguments);
        System.out.println(welcome);
        System.out.println(messages.getString("bye"));
}

//public static void main(String args[]) throws IOException {
//        displayMessages(Locale.forLanguageTag("ro"));
////-> Salut, Utilizatorul Duke s-a conectat la 2016-05-03, La revedere
//        displayMessages(Locale.getDefault());
////-> Hello, User Duke logged in at 2016-05-03, Goodbye
//}
