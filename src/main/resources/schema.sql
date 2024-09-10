CREATE OR REPLACE FUNCTION update_producer_rating()
RETURNS TRIGGER AS '
BEGIN
    UPDATE producer
    SET rating = (
        SELECT AVG(r.rate)
        FROM review r
        JOIN movie m ON r.movie_id = m.id
        WHERE m.producer_id = (SELECT producer_id FROM movie WHERE id = (SELECT movie_id FROM review WHERE id = COALESCE(NEW.id, OLD.id)))
    )
    WHERE id = (SELECT producer_id FROM movie WHERE id = (SELECT movie_id FROM review WHERE id = COALESCE(NEW.id, OLD.id)));
    RETURN NULL;
END;
' LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER update_producer_rating_trigger
AFTER INSERT OR UPDATE OR DELETE ON review
FOR EACH ROW EXECUTE FUNCTION update_producer_rating();