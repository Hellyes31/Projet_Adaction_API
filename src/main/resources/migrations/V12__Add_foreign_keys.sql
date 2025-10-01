ALTER TABLE "collects" ADD CONSTRAINT "collects_volunteer_id_foreign" FOREIGN KEY ("volunteer_id") REFERENCES "volunteers"("id");

ALTER TABLE "cities" ADD CONSTRAINT "cities_id_foreign" FOREIGN KEY ("id") REFERENCES "collects"("id");

ALTER TABLE "coordinates" ADD CONSTRAINT "coordinates_id_foreign" FOREIGN KEY ("id") REFERENCES "cities"("id");