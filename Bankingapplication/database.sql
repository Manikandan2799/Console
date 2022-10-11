create database BankApplication;
create table AccountDetails(
username varchar(50) ,
passWord varchar(50) ,
customerName varchar(50) ,
accountNumber int  AUTO_INCREMENT PRIMARY KEY,
mobileNumber varchar(100)  ,
emailId varchar(50) ,
balance varchar(500) );
ALTER TABLE accountdetails auto_increment=143450;
insert into AccountDetails ( username,passWord,customerName,mobileNumber,emailId,balance)values("Mani123","11111","Manikandan","9095117262","mani@gmail.com","50000");
select * from AccountDetails;
