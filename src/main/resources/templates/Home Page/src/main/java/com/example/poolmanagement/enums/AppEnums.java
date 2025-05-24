package com.example.poolmanagement.enums;

public class AppEnums {
    public enum Gender { M, F, Other }
    public enum UserStatus { Active, Inactive }
    public enum ScheduleStatus { Open, Closed, SoldOut }
    public enum TicketType { Adult, Child }
    public enum TicketStatus { Used, Unused }
    public enum SwimPackageStatus { Active, Inactive }
    public enum SubscriptionStatus { Active, Expired, Cancelled }
    public enum FeedbackStatus { Pending, Read, Responded }
    public enum Priority { Low, Medium, High }
    public enum SupportType { Technical, Billing, Facility, Other }
    public enum SwimClassStatus { Open, Full, Cancelled }
    public enum PaymentType { Package, SeparateFee }
    public enum PaymentStatus { Pending, Completed, Failed }
    public enum RegistrationStatus { Active, Cancelled }
}
