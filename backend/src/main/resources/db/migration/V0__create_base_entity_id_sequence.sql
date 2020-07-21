DO $$
BEGIN
  CREATE USER demouser;
  EXCEPTION WHEN DUPLICATE_OBJECT THEN
  RAISE NOTICE 'Not creating user demouser as it already exists';
END
$$;

create sequence id_sequence
	increment by 3;

alter sequence id_sequence owner to demouser;

