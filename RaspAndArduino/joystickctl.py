import pygame
import sys
import time

x = 50
y = 50
width = 40
height = 60
vel = 5

clock = pygame.time.Clock()
pygame.init()                                                                                                                                                           


screen = pygame.display.set_mode((800, 600))                                                                                                                            

joystick_count = pygame.joystick.get_count()
joysticks = []

pygame.joystick.init()
for i in range(joystick_count):
    joystick = pygame.joystick.Joystick(i)
    joysticks.append(joystick)

for j in joysticks:
    j.init()
    print("Joystick {}".format(i))
    
    # Get the name from the OS for the controller/joystick.                                                                                                              
    name = j.get_name()
    print("Joystick name: {}".format(name))
    
    # Usually axis run in pairs, up/down for one, and left/right for                                                                                                     
    # the other.                                                                                                                                                         
    axes = j.get_numaxes()
    print("Number of axes: {}".format(axes))
    
    for i in range(axes):
        axis = j.get_axis(i)
        print("Axis {} value: {:>6.3f}".format(i, axis))
        
        buttons = j.get_numbuttons()
        print("Number of buttons: {}".format(buttons))
        
    for i in range(buttons):
        button = j.get_button(i)
        print("Button {:>2} value: {}".format(i, button))
        
    hats = j.get_numhats()
    print("Number of hats: {}".format(hats))
    # get_axis(). Position is a tuple of int values (x, y).                                                                                                              
    for i in range(hats):
        hat = j.get_hat(i)
        print("Hat {} value: {}".format(i, str(hat)))
        
            
            
    pressed = pygame.key.get_pressed()
    if pressed[pygame.K_LEFT]:
        x -= vel
    if pressed[pygame.K_RIGHT]:
        x += vel
    if pressed[pygame.K_UP]:
        y -= vel
    if pressed[pygame.K_DOWN]:
        y += vel
        
    screen.fill((0, 0, 0))                                                                                                                                              
    pygame.draw.rect(screen, (0, 128, 255), pygame.Rect(x, y, 60, 60))                                                                                                  
    pygame.display.flip()                                                                                                                                               
    clock.tick(60)
    
pygame.quit()

