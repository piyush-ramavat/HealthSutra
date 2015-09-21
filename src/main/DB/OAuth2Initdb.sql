--TABLE: oauth_access_token
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove tinyint
);

create table oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);

create table oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

create table oauth_code (
  code VARCHAR(255), authentication BLOB
);



/*
Following insert is for: securityCtx.xml

<oauth:client-details-service id="clientDetails">
  <!-- client -->
  <oauth:client client-id="restapp"
   authorized-grant-types="authorization_code,client_credentials"
   authorities="ROLE_APP" scope="read,write,trust" secret="secret" />

  <oauth:client client-id="restapp"
   authorized-grant-types="password,authorization_code,refresh_token,implicit"
   secret="restapp" authorities="ROLE_APP" />

 </oauth:client-details-service>



 */
INSERT
INTO oauth_client_details (
        client_id,
        resource_ids,
        client_secret,
        scope,
        authorized_grant_types,
        web_server_redirect_uri,
        authorities,
        access_token_validity,
        refresh_token_validity,
        additional_information
) VALUES (
        'healthsutra',
        null,
        'c2hoaCpub3Qmd',
        null,
        'password',
        null,
        'TRUSTED_CLIENT',
        0,
        0,
        null
);