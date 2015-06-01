insert into users(username, password, enabled)
values('piyush.ramavat', 'Welcome@1', true),
('chintan.gatecha', 'Welcome@1', true),
('sample.trainer', 'Welcome@1', true),
('sample.patron', 'Welcome@1', true);


insert into authorities(username, authority)
values('piyush.ramavat', 'ROLE_SUPER_ADMIN'),
  ('piyush.ramavat', 'ROLE_TRAINER'),
  ('piyush.ramavat', 'ROLE_USER'),
  ('chintan.gatecha', 'ROLE_SUPER_ADMIN'),
  ('chintan.gatecha', 'ROLE_TRAINER'),
  ('chintan.gatecha', 'ROLE_USER'),
  ('sample.trainer', 'ROLE_TRAINER'),
  ('sample.trainer', 'ROLE_USER'),
  ('sample.patron', 'ROLE_USER');