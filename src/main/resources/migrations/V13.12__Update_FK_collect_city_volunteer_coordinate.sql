ALTER TABLE "cities"
ADD COLUMN coordinates_id BIGINT DEFAULT NULL;

ALTER TABLE "collects" ADD CONSTRAINT "collects_volunteer_id_foreign" FOREIGN KEY ("volunteer_id") REFERENCES "volunteers"("id");

ALTER TABLE "collects" ADD CONSTRAINT "collects_city_id_foreign" FOREIGN KEY ("city_id") REFERENCES "cities"("id");

ALTER TABLE "cities" ADD CONSTRAINT "cities_coordinates_id_foreign" FOREIGN KEY ("coordinates_id") REFERENCES "coordinates"("id");
