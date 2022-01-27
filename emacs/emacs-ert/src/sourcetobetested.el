;;https://blog.abrochard.com/ert-tests.html
(defun silly-division (a b)
  "Silly divide A by B."
  (if (equal b 1)
      a
    (/ a b)))

(provide 'silly-division)
