ALTER TABLE products
    ADD img_url VARCHAR(255) NULL;

ALTER TABLE products
DROP
COLUMN real_image_url;