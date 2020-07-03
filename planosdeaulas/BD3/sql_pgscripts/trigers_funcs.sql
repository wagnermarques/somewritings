CREATE TRIGGER novofunc
    BEFORE DELETE ON functionario
    FOR EACH ROW
    EXECUTE PROCEDURE check_account_update();
