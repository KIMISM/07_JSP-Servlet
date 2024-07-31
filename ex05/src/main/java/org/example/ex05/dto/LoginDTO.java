package org.example.ex05.dto;

import java.util.Objects;

public class LoginDTO { //getter,setter,필드 생성자 가지고 있으면 Java Bean으러 사용 가능
    private String name; //attribute, 기본적으로 바깥에서 접근하기 힘듦
    private String passwd;

    public LoginDTO() {
    }

    public LoginDTO(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public String getName() { //property, getter/setter를 통해서 바깥에서 접근가능
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDTO loginDTO = (LoginDTO) o;
        return Objects.equals(name, loginDTO.name) && Objects.equals(passwd, loginDTO.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passwd);
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
