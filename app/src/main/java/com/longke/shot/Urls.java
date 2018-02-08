package com.longke.shot;

/**
 * Created by longke on 2017/12/13.
 */

public class Urls {
    public static  String BASE_URL="http://192.168.31.121:81";

    public static final String GetTrainStudentData = BASE_URL +"/api/TrainStudent/GetTrainStudentDataByTVCode";
    public static final String DeviceIsRegist = BASE_URL +"/api/Device/DeviceIsRegist";
    public static final String EndShoot = BASE_URL +"/api/TrainStudent/EndShoot";
    public static final String StartShoot = BASE_URL +"/api/TrainStudent/StartShoot";
    public static final String RegistPad = BASE_URL +"/api/Device/RegistTV";
    public static final String GetTrainStudentDataByGroupId = BASE_URL +"/api/TrainStudent/GetTrainStudentDataByGroupIdAndTVCode";




}
