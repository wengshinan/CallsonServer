package com.cloud.son.entity;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class CallsonUser {

    public class UserProperty {
        public UserProperty(){}

        protected String cnName;
        protected String enName;
        protected int age;
        protected String description;
        protected String password;
        protected String phone;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


    }

    /**
     * 用户类型
     */
    public enum UserType {
        CUSTOMER, //需求客户
        PROVIDER, //服务者
        MANAGER, //管理员
        VISITOR, //游客
    }

    protected String uId;
    protected UserType type;
    protected UserProperty uProp;

    public String getUId() {
        return uId;
    }

    public void setUId(String id) {
        uId = id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public UserProperty getUProp() {
        return uProp;
    }

    public void setUProp(UserProperty prop) {
        uProp = prop;
    }

}
