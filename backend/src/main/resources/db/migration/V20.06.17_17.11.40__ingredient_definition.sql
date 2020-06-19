DO $$
	BEGIN
	IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'ingredient_definition') THEN
		CREATE TYPE ingredient_definition AS ENUM('FLOUR', 'WATER', 'SALT', 'PEPPER', 'BEEF');
	END IF;
 END$$;
