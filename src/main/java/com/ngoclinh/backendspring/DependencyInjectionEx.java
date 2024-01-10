//package com.ngoclinh.backendspring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//public class DependencyInjectionEx {
//    @Autowired
//    private Minh minh;
//
//    public static void main(String[] args) {
//        Minh minh = new Minh();
//
//        CanhTay canhTay = new CanhTay();
//
//        BanTay banTay = new BanTay();
//
//        NgonTay ngonTay = new NgonTay();
//
//        DotTay dotTay = new DotTay();
//
//        // KHuc inject
//        ngonTay.setDotTay(dotTay);
//        banTay.setNgonTay(ngonTay);
//        canhTay.setBanTay(banTay);
//        minh.setCanhTay(canhTay);
//    }
//}
//
//@Component
//class Minh{
//    private CanhTay canhTay;
//}
//
//@Component
//class CanhTay{
//    private BanTay banTay;
//}
//
//class BanTay{
//    private NgonTay ngonTay;
//}
//
//class NgonTay{
//    private DotTay dotTay;
//}
//
//class DotTay{
//
//}
