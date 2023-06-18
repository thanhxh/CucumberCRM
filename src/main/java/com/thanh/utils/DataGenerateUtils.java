package com.thanh.utils;

import com.thanh.helpers.DataFakerHelpers;

import static com.thanh.helpers.DataFakerHelpers.getFaker;

public class DataGenerateUtils {


    public void testData() {
        System.out.println(getProgrammingLanguage());
    }

    public static String getProgrammingLanguage() {
        try {
            return getFaker().programmingLanguage().name();
        } catch (Exception e) {
            return null;
        }

    }

    public static String getFullAddress() {
        try {
            return DataFakerHelpers.getFaker().address().fullAddress();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getRandomVAT() {
        try {
            return DataFakerHelpers.getFaker().regexify("[0-9]{9}");
        } catch (Exception e) {
            return null;
        }
    }

    public static String getNameCity() {
        try {
            return DataFakerHelpers.getFaker().address().cityName();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getNameState() {
        try {
            return DataFakerHelpers.getFaker().address().state();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getZipCode() {
        try {
            return DataFakerHelpers.getFaker().address().zipCode();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getPhoneNumber() {
        try {
            return getFaker().phoneNumber().phoneNumberNational();
        } catch (Exception e) {
            return null;
        }
    }

    public static long getRandomNumber() {
        try {
            return getFaker().number().randomNumber();
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getNumberPositive() {
        try {
            return getFaker().number().positive();
        } catch (Exception e) {
            return 0;
        }

    }

    public static int getNumberNegative() {
        try {
            return getFaker().number().negative();
        } catch (Exception e) {
            return 0;
        }

    }

    public static int getOrderNumber() {
        try {
            return getFaker().number().numberBetween(0, 100);
        } catch (Exception e) {
            return 0;
        }

    }

    public static String getFunnyName() {
        try {
            return getFaker().funnyName().name();
        } catch (Exception e) {
            return null;
        }

    }

    public static String getCompanyName() {
        try {
            return getFaker().company().name();
        } catch (Exception e) {
            return null;
        }

    }

    // Hàm để tạo ra một số nguyên ngẫu nhiên trong phạm vi từ min đến max
    public static int getRandomInt(int min, int max) {
        return DataFakerHelpers.getFaker().number().numberBetween(min, max);
    }

    // Hàm để tạo ra một chuỗi ngẫu nhiên với độ dài length
    public static String getRandomString(int length) {

        try {
            return DataFakerHelpers.getFaker().regexify("[a-zA-Z0-9]{" + length + "}");
        } catch (Exception e) {
            return null;
        }
    }

    // Hàm để tạo ra một tên ngẫu nhiên
    public static String getFullName() {

        try {
            return "TT_ " + DataFakerHelpers.getFaker().name().fullName();
        } catch (Exception e) {
            return null;
        }
    }

    // Hàm để tạo ra một địa chỉ ngẫu nhiên


    // Hàm để tạo ra một số điện thoại ngẫu nhiên
    public static String getPhoneNumber(String number) {

        try {
            String numberPhone = DataFakerHelpers.getFaker().phoneNumber().phoneNumber().replaceAll("[^0-9]", "");
            if (numberPhone.length() > 10) {
                numberPhone = numberPhone.substring(0, 10); // giới hạn số nhỏ hơn hoặc bằng 10
            }
            return number + numberPhone;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getPhoneNumberLimit() {

        try {
            String numberPhone = DataFakerHelpers.getFaker().phoneNumber().phoneNumber().replaceAll("[^0-9]", "");
            if (numberPhone.length() > 10) {
                numberPhone = numberPhone.substring(0, 10); // giới hạn số nhỏ hơn hoặc bằng 10
            }
            return "0" + numberPhone;
        } catch (Exception e) {
            return null;
        }
    }

    // Hàm để tạo ra một email ngẫu nhiên
    public static String getRandomEmail() {
        try {
            return DataFakerHelpers.getFaker().internet().emailAddress();
        } catch (Exception e) {
            return null;
        }
    }
}
