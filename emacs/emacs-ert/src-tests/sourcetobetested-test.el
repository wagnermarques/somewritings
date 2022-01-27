(add-to-list 'load-path "/home/administrador/fzlbpms/submodules/somewritings/emacs/emacs-ert/src/")

(require 'silly-division) ;;must eval-buffer of that file is needed
(require 'ert)

(ert-deftest silly-test-division ()
  (should (equal 4 (silly-division 8 2))))

(ert 'silly-test-division)
