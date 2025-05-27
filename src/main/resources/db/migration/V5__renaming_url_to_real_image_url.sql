ALTER TABLE products
    ADD real_image_url VARCHAR(255) NULL;

ALTER TABLE products
DROP
COLUMN url;