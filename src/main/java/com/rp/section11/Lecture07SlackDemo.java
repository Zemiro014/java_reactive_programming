package com.rp.section11;

import com.rp.courseutil.Util;
import com.rp.section11.assignment.SlackMember;
import com.rp.section11.assignment.SlackRoom;

public class Lecture07SlackDemo {


    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("Sam");
        SlackMember jake = new SlackMember("Jake");
        SlackMember mike = new SlackMember("Mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi all...");
        Util.sleepSecond(4);

        jake.says("Hey!");
        sam.says("WhatsApp bro!");
        Util.sleepSecond(4);

        slackRoom.joinRoom(mike);
        mike.says("Hey guys.. glad to be here...");

    }
}
