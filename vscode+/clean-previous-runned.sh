sudo pkill -f antigravity
sudo pkill -f code   
sudo apt purge antigravity -y
sudo apt autoremove -y
sudo rm -rf /usr/local/bin/antigravity
sudo rm -rf /usr/local/bin/code
sudo rm -rf /opt/antigravity
sudo rm -rf /opt/visual-studio-code
sudo rm -rf ~/.config/antigravity
sudo rm -rf ~/.config/Code
sudo rm -rf ~/.local/share/antigravity
sudo rm -rf ~/.vscode
sudo rm -rf ~/.cache/Code
sudo rm -rf ~/.cache/antigravity
sudo rm -rf ~/Desktop/antigravity.desktop
sudo rm -rf ~/Desktop/Visual\ Studio\ Code.desktop
sudo rm -rf /usr/share/applications/antigravity.desktop
sudo rm -rf /usr/share/applications/code.desktop
sudo rm -rf /usr/share/icons/hicolor/*/apps/antigravity.png
sudo rm -rf /usr/share/icons/hicolor/*/apps/code.png
echo "Previous installations of Antigravity and Visual Studio Code have been removed."

