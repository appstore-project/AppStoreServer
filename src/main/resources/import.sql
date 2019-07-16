insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 1000, 'خروس جنگی', 'کاسپین' ,'3.8', 'امتیازی', 1, 2300, '20.1', '1.1', '1-2-689777-63-0-181859', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 2000, 'طاقچه', 'کاسپین' ,'4.8', 'دانستنی‌ها', 1, 2000, '23.1', '1.1', '1-2-689777-63-0-181855', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 3000, 'ديرين شاه', 'کاسپین' ,'4.8', 'تفننی', 1, 4500, '29.3', '1.5', '1-2-689777-63-0-181857', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 4000, 'ضربه کاشته', 'گیم' ,'0.8', 'ورزشی', 1, 1800, '40.1', '4.1', '1-2-689777-63-0-181856', 0, 1);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 5000, 'کمد', 'علی' ,'3.5', 'ابزارها', 0, 1200, '3.5', '1.4', '1-2-689777-63-0-181858', 0, 0);
insert into app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 6000, 'Call of Duty', 'EAGames' ,'4.6', 'Strategy', 1, 3500000, '80', '4.3', '1-2-435757-63-0-181890', 25000, 1);

insert into aps_category(id, name) values (1, 'Tools');
insert into aps_category(id, name) values (2, 'Games');

insert into app (id, title, category_id) values (seq_app_id.nextval, 'NetTest', 1);
insert into app (id, title, category_id) values (seq_app_id.nextval, 'New Galaxy', 2);
insert into app (id, title, category_id) values (seq_app_id.nextval, 'Stars War', 2);

insert into Collection(id, position, title) values (seq_coll_id.nextval, 2, 'Top New Games');
insert into Collection_Apps(collection_id, apps_id) values (seq_coll_id.currval, 2);
insert into Collection_Apps(collection_id, apps_id) values (seq_coll_id.currval, 3);

insert into Collection (id, position, title) values (seq_coll_id.nextval, 1, 'New Tools');
insert into Collection_Apps(collection_id, apps_id) values (seq_coll_id.currval, 1);

insert into App_User(user_id, username, password) values (seq_user_id.nextval, 'erfan', '$2a$10$fw16weS5K06GiuSRtUyt2.jeSQboQtTvV0Vvx8ZsMSuVJHHgTT9TC')

-- insert into FILE_BODY select * from FileBCopy;