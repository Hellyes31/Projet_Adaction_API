ALTER TABLE "cities"
ADD COLUMN coordinates_id INTEGER DEFAULT NULL;

ALTER TABLE "collects" ADD CONSTRAINT "collects_volunteer_id_foreign" FOREIGN KEY ("volunteer_id") REFERENCES "volunteers"("id");

ALTER TABLE "cities" ADD CONSTRAINT "cities_id_foreign" FOREIGN KEY ("id") REFERENCES "collects"("city_id");

ALTER TABLE "coordinates" ADD CONSTRAINT "coordinates_id_foreign" FOREIGN KEY ("id") REFERENCES "cities"("coordinates_id");
