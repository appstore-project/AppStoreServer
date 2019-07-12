create tablespace appstore_ts datafile autoextend on maxsize 5G;

create appUser appstore identified by asback default tablespace appstore_ts;

grant create session, resource, dba to appstore;