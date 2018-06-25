#include <gtk/gtk.h>

GtkWidget *main_window;

int main(int argc, char *argv[]){

  
  gtk_init(& argc, &argv);

  window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
  gtk_window_set_title(GTK_WINDOW(main_window), "GKT Top Level Window");
  gtk_window_set_default_icon_name("fprint_demo");
  gtk_widget_show (main_window);
  gtk_main();
  return 0;
}


int main(int argc, char **argv)
{
	int r;

	r = fp_init();
	if (r < 0)
          return r;



	r = setup_pollfds();
	if (r < 0)
		return r;

	mwin_create();
	mwin_populate_devs();
	mwin_select_first_dev();

	gtk_main();

	if (fpdev)
		fp_dev_close(fpdev);
	fp_exit();
	return 0;
}
