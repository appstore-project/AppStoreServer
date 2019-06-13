insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 4000, 'طاقچه', 'کاسپین' ,'4.8', 'دانستنی‌ها', 1, 2000, '23.1', '1.1', '۱-۲-۶۸۹۷۷۷-۶۳-۰-۱۸۱۸۵۵', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 2000, 'سلطان ضربه کاشته', 'گیم' ,'0.8', 'ورزشی', 1, 1800, '40.1', '4.1', '۱-۲-۶۸۹۷۷۷-۶۳-۰-۱۸۱۸۵۵', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 3000, 'ديرين شاه', 'کاسپین' ,'4.8', 'تفننی', 1, 4500, '29.3', '1.5', '۱-۲-۶۸۹۷۷۷-۶۳-۰-۱۸۱۸۵۵', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 5000, 'کمد', 'علی' ,'3.5', 'ابزارها', 0, 1200, '3.5', '1.4', '۱-۲-۶۸۹۷۷۷-۶۳-۰-۱۸۱۸۵۵', 0, 0);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 1000, 'خروس جنگی', 'کاسپین' ,'3.8', 'امتیازی', 1, 2300, '20.1', '1.1', '۱-۲-۶۸۹۷۷۷-۶۳-۰-۱۸۱۸۵۵', 0, 1);

insert into app (id, title, category) values (seq_app_id.nextval, 'NetTest', 'Tools');
insert into app (id, title, category) values (seq_app_id.nextval, 'New Galaxy', 'Games');
insert into app (id, title, category) values (seq_app_id.nextval, 'Stars War', 'Games');

-- insert into app (id, title, category, rate) values (seq_app_id.nextval, 'Stars War', 'Games', 5);

insert into Collection (id, position, title) values (seq_coll_id.nextval, 2, 'Top New Games');
insert into Collection_Apps(collection_id, apps_id) values (seq_coll_id.currval, 2);
insert into Collection_Apps(collection_id, apps_id) values (seq_coll_id.currval, 3);

insert into Collection (id, position, title) values (seq_coll_id.nextval, 1, 'New Tools');
insert into Collection_Apps(collection_id, apps_id) values (seq_coll_id.currval, 1);

--
insert into FILE_BODY select * from FileBCopy;