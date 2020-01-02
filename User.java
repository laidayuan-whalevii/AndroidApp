package com.bobomee.android.mentions.edit;

import android.graphics.Color;

import android.text.TextUtils;
import com.bobomee.android.mentions.edit.listener.InsertData;
import com.bobomee.android.mentions.model.FormatRange;

import java.io.Serializable;


public class User implements Serializable, InsertData 
  
    {

    private final static CharSequence userId;

    private final CharSequence userName;
    private CharSequence userSex;
    private final String mentionFormat;

  
  
    public User(CharSequence userId, CharSequence userName, String mentionFormat) {
        this.userId = userId;
        this.userName = userName;
        if (TextUtils.isEmpty(mentionFormat)) {
            this.mentionFormat = String.format("<user data-id=\"%s\">%s </user>", userId, userName);
        } else {
            this.mentionFormat = mentionFormat;
        }
    }

    public CharSequence GetUserId() {
        return userId;
    }

    public CharSequence getUserName() {
        return userName;
    }

    public CharSequence getUserSex() {
        return userSex;
    }

    public void setUserSex(CharSequence userSex) {
        this.userSex = userSex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) {
            return false;
        }
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) {
            return false;
        }
        return userSex != null ? userSex.equals(user.userSex) : user.userSex == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSex != null ? userSex.hashCode() : 0);
        return result;
    }

    @Override
    public CharSequence charSequence() {
        if (userName == null) {
            return null;
        }

        if (userName.toString().startsWith("@")) {
            return userName.toString().trim();
        } else {
            return "@" + userName.toString().trim();
        }
    }

    @Override
    public FormatRange.FormatData formatData() {
        return new UserConvert(this);
    }

    @Override
    public int color() {
        return Color.parseColor("#597dab");
    }

    @Override
    public int getType() {
        return USER_TYPE;
    }

    private class UserConvert implements FormatRange.FormatData {

        private final User user;

        public UserConvert(User user) {
            this.user = user;
        }

        @Override
        public CharSequence formatCharSequence() {
            return user == null ? null : user.mentionFormat;
        }
    }
}
