/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.html;

/**
 *
 * @author Administrador
 */
public class Input {

    private String id = "";
    private String nome = "";
    private String type = "";
    private String label = "";
    private boolean required = false;
    private int size = 0;
    private String value = "";
    private String formaction = "";
    private String complemento = "";

    public Input(String id, String nome, String type) {
        this.id = id;
        this.nome = nome;
        this.type = type;
    }

    public Input(String id, String nome, String type, String label) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.label = label;

    }

    public Input(String id, String nome, String type, String label, int size) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.label = label;
        this.size = size;

    }

    public Input(String id, String nome, String type, String label, int size, boolean required) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.label = label;
        this.size = size;
        this.required = required;

    }

    public Input(String id, String nome, String type, String label, int size, boolean required, String value) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.label = label;
        this.size = size;
        this.required = required;
        this.value = value;

    }

    public Input(String id, String nome, String type, String label, int size, boolean required, String value, String formaction) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.label = label;
        this.size = size;
        this.required = required;
        this.value = value;
        this.formaction = formaction;

    }

    public Input(String id, String nome, String type, String label, int size, boolean required, String value, String formaction, String complemento) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.label = label;
        this.size = size;
        this.required = required;
        this.value = value;
        this.formaction = formaction;
        this.complemento = complemento;

    }

    public Input() {
        this.type = "text";

    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormaction() {
        return formaction;
    }

    public void setFormaction(String formaction) {
        this.formaction = formaction;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTag() {
        String s = "";
        if (this.label != "") {
            s = "<label for=\"" + this.id + "\">" + this.label + "</label>\n";
        }

        s += "<input type=\"" + this.type + "\" id=\"" + this.id + "\" name=\"" + this.nome + "\"";
        if (size > 0) {
            s += " size=" + this.size;
        }
        if (this.complemento != "" && this.complemento != null) {
            s += this.complemento;
        }
        if (this.formaction != "" && this.formaction != null) {
            s += " formaction=\"" + this.complemento + "\"";
        }
        if (this.value != "" && this.value != null) {
            s += " value=\"" + this.value + "\"";
        }
        if (this.required == true) {
            s += " required";
        }
        s += ">\n";

        return s;
    }

}
