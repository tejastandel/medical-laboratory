/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xfinity.view.widget;

/**
 *
 * @author supun
 */
public class Title {

        public String title;
        public Gender gender;

        public Title(String title, Gender gender) {
            this.title = title;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return title;
        }
}
