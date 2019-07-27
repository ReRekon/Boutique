/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/7/27 21:35:13                           */
/*==============================================================*/


drop table if exists admin;

drop table if exists admin_adress;

drop table if exists admin_bankcard;

drop table if exists category;

drop table if exists comment;

drop table if exists commentreply;

drop table if exists foucs_image;

drop table if exists goods_item;

drop table if exists goods_specific;

drop table if exists history;

drop table if exists orders;

drop table if exists product;

drop table if exists product_image;

drop table if exists shop_cart;

drop table if exists specifiction_image;

drop table if exists user_collection;

drop table if exists user_order;

drop table if exists 商品类型2级;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   u_id                 int(11) not null auto_increment,
   u_name               varchar(32),
   u_pur                varchar(256),
   u_pwd                varchar(128),
   u_emil               varchar(64),
   u_signature          varchar(64),
   u_tel                varchar(16),
   u_vip                bigint(32),
   state                int(11),
   createtime           datetime,
   updatetime           datetime,
   otpcode              varchar(256),
   primary key (u_id)
);

/*==============================================================*/
/* Table: admin_adress                                          */
/*==============================================================*/
create table admin_adress
(
   aa_id                int(11) not null auto_increment,
   u_id                 int(11),
   aa_name              varchar(32),
   telephone            varchar(16),
   province             varchar(16),
   city                 varchar(16),
   area                 varchar(16),
   street               varchar(128),
   aa_adress            varchar(128),
   state                int default 1,
   primary key (aa_id)
);

/*==============================================================*/
/* Table: admin_bankcard                                        */
/*==============================================================*/
create table admin_bankcard
(
   ab_id                int(11) not null auto_increment,
   u_id                 int(11),
   ab_type              varchar(32),
   ab_num               varchar(32),
   primary key (ab_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   c_id                 int(11) not null auto_increment,
   c_name               varchar(16),
   state                int(11),
   primary key (c_id)
);

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   id                   int(11) not null,
   t_id                 int(11),
   o_id                 int(11),
   u_id                 int(11),
   image_path           varchar(256),
   description          varchar(128),
   time                 date,
   state                int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: commentreply                                          */
/*==============================================================*/
create table commentreply
(
   追加评论ID               int(11) not null auto_increment,
   评论ID                 int(11),
   追加评论内容               varchar(128),
   追加评论时间               date,
   primary key (追加评论ID)
);

/*==============================================================*/
/* Table: foucs_image                                           */
/*==============================================================*/
create table foucs_image
(
   f_id                 int(12) not null auto_increment,
   image                varchar(128),
   description          varchar(128),
   state                int(10),
   primary key (f_id)
);

/*==============================================================*/
/* Table: goods_item                                            */
/*==============================================================*/
create table goods_item
(
   gi_id                int(11) not null auto_increment,
   t_id                 int(11),
   sc_id                int(11),
   gs_id                int(11),
   t_num                bigint,
   state                int(11),
   final_pay            decimal(11,2),
   logo                 varchar(256),
   total_prirce         dec(11,2),
   primary key (gi_id)
);

/*==============================================================*/
/* Table: goods_specific                                        */
/*==============================================================*/
create table goods_specific
(
   gs_id                int(11) not null auto_increment,
   t_id                 int(11),
   gd_desc              varchar(16),
   t_price              decimal(11,2),
   primary key (gs_id)
);

/*==============================================================*/
/* Table: history                                               */
/*==============================================================*/
create table history
(
   id                   int(11) not null auto_increment,
   t_id                 int(11),
   u_id                 int(11),
   times                date,
   numbers              int(11),
   state                int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   o_id                 int(11) not null auto_increment,
   u_id                 int(11),
   o_stauts             int,
   o_price              decimal(11,2),
   o_num                bigint,
   o_starttime          datetime,
   o_finishtime         datetime,
   final_price          decimal(11,2),
   o_number             varchar(256),
   primary key (o_id)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   t_id                 int(11) not null auto_increment,
   c_id                 int(11),
   c_id2                int(12),
   t_name               varchar(128),
   t_dis                varchar(256),
   t_coll_count         bigint,
   inventory            bigint,
   logo                 varchar(256),
   heat                 int(11),
   mark                 float(11),
   state                int(11),
   discount             float default 1,
   primary key (t_id)
);

/*==============================================================*/
/* Table: product_image                                         */
/*==============================================================*/
create table product_image
(
   id                   int(11) not null auto_increment,
   t_id                 int(11),
   pro_image            varchar(256),
   decription           varchar(128),
   state                int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: shop_cart                                             */
/*==============================================================*/
create table shop_cart
(
   sc_id                int(11) not null auto_increment,
   u_id                 int(11),
   primary key (sc_id)
);

/*==============================================================*/
/* Table: specifiction_image                                    */
/*==============================================================*/
create table specifiction_image
(
   id                   int(11) not null auto_increment,
   gs_id                int(11),
   sp_image             varchar(256),
   decription           varchar(128),
   state                int(11),
   primary key (id)
);

/*==============================================================*/
/* Table: user_collection                                       */
/*==============================================================*/
create table user_collection
(
   uc_id                int(11) not null auto_increment,
   t_id                 int(11),
   u_id                 int(11),
   uc_time              datetime,
   state                int(11),
   primary key (uc_id)
);

/*==============================================================*/
/* Table: user_order                                            */
/*==============================================================*/
create table user_order
(
   uo_id                int(11) not null auto_increment,
   o_id                 int(11),
   t_id                 int(11),
   gs_id                int(11),
   uo_num               bigint,
   final_pay            decimal(11,2),
   logo                 varchar(256),
   primary key (uo_id)
);

/*==============================================================*/
/* Table: 商品类型2级                                                */
/*==============================================================*/
create table 商品类型2级
(
   c_id2                int(12) not null,
   c_id                 int(11),
   c_name2              varchar(128),
   state2               varchar(128),
   primary key (c_id2)
);

