create database questionnaire;
use questionnaire;
create table bytedance(
 username varchar(20)  comment '用户名',
 id int unsigned primary key auto_increment comment '编号',
 age varchar(20)  not null comment '您今年的年龄',
 know varchar(20) not null comment'你曾了解过字节跳动这个公司吗' ,
 app varchar(70) not null comment'你平时最常用字节跳动哪些产品',
 short_video varchar(80) not null comment'你喜欢的短视频类型是',
 publish boolean not null comment'作为用户，你自己生产过内容吗（是否发布过视频类、文字类作品）',
 spend_time varchar(40) not null comment'你一天大概花多少时间在刷小视频上',
 shortcoming varchar(120) not null comment'您在使用字节跳动产品（如今日头条、抖音等过程中），有哪些地方还做的不够好',
 recharge varchar(40) not null comment'有无充值过字节跳动旗下产品',
 activity varchar(100) not null comment'你最常参加字节跳动产品的哪些活动',
 innovation varchar(40) not null comment'你最希望字节跳动创新哪方面的内容' ,
 hope boolean not null comment'你认为字节跳动有望生产长视频（电视剧/电影）吗',
 agree boolean not null comment'字节跳动会在数字化发展的过程中与腾讯、爱奇艺、优酷、芒果等平台进行长视频的较量，你同意这种观点吗',
 ability varchar(40) not null comment'你认为字节跳动主要依靠什么能力发展并且成功“出海”',
 prospect text not null comment'你对字节跳动在传媒领域有什么展望？（生产影视、小说等数字内容）'
);
select *
from bytedance;


create table users(
username varchar(20) primary key comment '用户名',
`password` varchar(20) not null comment'密码',
questionnaireid int unsigned comment '编号'
);

alter table bytedance
drop FOREIGN KEY bytedance_users;
alter table users
drop FOREIGN KEY users_bytedance;


truncate table bytedance;
select *
from users;
delete from bytedance where id=7;