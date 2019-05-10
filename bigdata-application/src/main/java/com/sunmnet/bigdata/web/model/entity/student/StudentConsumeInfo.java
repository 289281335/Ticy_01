package com.sunmnet.bigdata.web.model.entity.student;

public class StudentConsumeInfo {

    private String studentNo;

    private String consumeYear;

    private String consumeMonth;

    private String studentName;

    private String gender;

    private Long breakfastAmount;

    private Integer breakfastCount;

    private Long lunchAmount;

    private Integer lunchCount;

    private Long dinnerAmount;

    private Integer dinnerCount;

    private Long supperAmount;

    private Integer supperCount;

    private Long fruitAmount;

    private Integer fruitCount;

    private Long internetAmount;

    private Long marketAmount;

    private Long bathAmount;

    private Long bookAmount;

    private Long hospitalAmount;

    private Long otherAmount;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getConsumeYear() {
        return consumeYear;
    }

    public void setConsumeYear(String consumeYear) {
        this.consumeYear = consumeYear;
    }

    public String getConsumeMonth() {
        return consumeMonth;
    }

    public void setConsumeMonth(String consumeMonth) {
        this.consumeMonth = consumeMonth;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Long getBreakfastAmount() {
        return breakfastAmount;
    }

    public void setBreakfastAmount(Long breakfastAmount) {
        this.breakfastAmount = breakfastAmount;
    }

    public Integer getBreakfastCount() {
        return breakfastCount;
    }

    public void setBreakfastCount(Integer breakfastCount) {
        this.breakfastCount = breakfastCount;
    }

    public Long getLunchAmount() {
        return lunchAmount;
    }

    public void setLunchAmount(Long lunchAmount) {
        this.lunchAmount = lunchAmount;
    }

    public Integer getLunchCount() {
        return lunchCount;
    }

    public void setLunchCount(Integer lunchCount) {
        this.lunchCount = lunchCount;
    }

    public Long getDinnerAmount() {
        return dinnerAmount;
    }

    public void setDinnerAmount(Long dinnerAmount) {
        this.dinnerAmount = dinnerAmount;
    }

    public Integer getDinnerCount() {
        return dinnerCount;
    }

    public void setDinnerCount(Integer dinnerCount) {
        this.dinnerCount = dinnerCount;
    }

    public Long getSupperAmount() {
        return supperAmount;
    }

    public void setSupperAmount(Long supperAmount) {
        this.supperAmount = supperAmount;
    }

    public Integer getSupperCount() {
        return supperCount;
    }

    public void setSupperCount(Integer supperCount) {
        this.supperCount = supperCount;
    }

    public Long getFruitAmount() {
        return fruitAmount;
    }

    public void setFruitAmount(Long fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public Integer getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(Integer fruitCount) {
        this.fruitCount = fruitCount;
    }

    public Long getInternetAmount() {
        return internetAmount;
    }

    public void setInternetAmount(Long internetAmount) {
        this.internetAmount = internetAmount;
    }

    public Long getMarketAmount() {
        return marketAmount;
    }

    public void setMarketAmount(Long marketAmount) {
        this.marketAmount = marketAmount;
    }

    public Long getBathAmount() {
        return bathAmount;
    }

    public void setBathAmount(Long bathAmount) {
        this.bathAmount = bathAmount;
    }

    public Long getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Long bookAmount) {
        this.bookAmount = bookAmount;
    }

    public Long getHospitalAmount() {
        return hospitalAmount;
    }

    public void setHospitalAmount(Long hospitalAmount) {
        this.hospitalAmount = hospitalAmount;
    }

    public Long getOtherAmount() {
        return otherAmount;
    }

    public void setOtherAmount(Long otherAmount) {
        this.otherAmount = otherAmount;
    }
}