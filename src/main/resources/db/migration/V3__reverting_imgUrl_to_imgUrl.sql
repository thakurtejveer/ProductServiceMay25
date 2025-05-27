ALTER TABLE products
    ADD image_url VARCHAR(255) NULL;

ALTER TABLE products
DROP
COLUMN img_url;