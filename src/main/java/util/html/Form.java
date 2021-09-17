/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.html;

import java.util.ArrayList;
import java.util.List;
import util.Config;

/**
 *
 * @author Administrador
 */
public class Form {

    private String name;
    private String method;
    private String action;
    private String target;
    private String rel;
    private String enctype;
    private boolean autocomplete;
    private boolean novalidate;
    private String accept_charset;
    private List<Input> inputs;

    public Form(String name, String method, String action) {
        this.name = name;
        this.method = method;
        this.action = action;
        inputs = new ArrayList<>();
    }
    public void addInput(Input input){
        this.inputs.add(input);
    }
    public Form() {
        inputs = new ArrayList<>();
    }

    public Form(String name, String method, String action, String target) {
        this.name = name;
        this.method = method;
        this.action = action;
        this.target = target;
        inputs = new ArrayList<>();
    }

    public Form(String name, String method, String action, String target, String rel) {
        this.name = name;
        this.method = method;
        this.action = action;
        this.target = target;
        this.rel = rel;
        inputs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getEnctype() {
        return enctype;
    }

    public void setEnctype(String enctype) {
        this.enctype = enctype;
    }

    public boolean isAutocomplete() {
        return autocomplete;
    }

    public void setAutocomplete(boolean autocomplete) {
        this.autocomplete = autocomplete;
    }

    public boolean isNovalidate() {
        return novalidate;
    }

    public void setNovalidate(boolean novalidate) {
        this.novalidate = novalidate;
    }

    public String getAccept_charset() {
        return accept_charset;
    }

    public void setAccept_charset(String accept_charset) {
        this.accept_charset = accept_charset;
    }

    public String getTag() {
        String s;
        s = "<form id=" + Config._AD + this.name + Config._AD
                + " action=" + Config._AD + this.action + Config._AD + ">\n";

        for (int i = 0; i < inputs.size(); i++) {
            Input get = inputs.get(i);
            s += get.getTag() +"\n";
        }

        s += "</form>";
        return s;

    }

}
