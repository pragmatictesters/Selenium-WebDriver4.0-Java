package com.pragmatic.java.annotations;

public class JavaAnnotationsExample {


    /**
     * @Deprecated
     * This method is deprecated
     */
    @Deprecated
    public void deprecatedMethod(){
        System.out.println("This is a deprecated method");
    }

    @SuppressWarnings("deprecated")
    public void useDeprecatedMethod(){
        deprecatedMethod();
        System.out.println("I am using a deprecated method");
    }

    @SuppressWarnings({"deprecated", "checked"})
    public void suppressMultipleWarnings(){
        System.out.println("I suppress multiple warnings");
    }


}
