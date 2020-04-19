import pygame
import sys
import time

x = 50
y = 50
width = 40
height = 60
vel = 5

clock = pygame.time.Clock()
#pygame.init()



#screen = pygame.display.set_mode((800, 600))


joystick_count = pygame.joystick.get_count()

pygame.joystick.init()
for i in range(joystick_count):
    joystick = pygame.joystick.Joystick(i)
    joystick.init()
    print("Joystick {}".format(i))

    # Get the name from the OS for the controller/joystick.
    name = joystick.get_name()
    print("Joystick name: {}".format(name))

    # Usually axis run in pairs, up/down for one, and left/right for
    # the other.
    axes = joystick.get_numaxes()
    print("Number of axes: {}".format(axes))
    
    for i in range(axes):
        axis = joystick.get_axis(i)
        print("Axis {} value: {:>6.3f}".format(i, axis))
        
        buttons = joystick.get_numbuttons()
        print("Number of buttons: {}".format(buttons))

    for i in range(buttons):
        button = joystick.get_button(i)
        print("Button {:>2} value: {}".format(i, button))

    hats = joystick.get_numhats()
    print("Number of hats: {}".format(hats))
    # get_axis(). Position is a tuple of int values (x, y).
    for i in range(hats):
        hat = joystick.get_hat(i)
        print("Hat {} value: {}".format(i, str(hat)))
        

run = True
while run:
    pygame.time.delay(100)
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
        if event.type == pygame.JOYAXISMOTION:
            x += vel
        if event.type == pygame.JOYHATMOTION:
            x -= vel

        if event.type == pygame.JOYBALLMOTION:
            print("pygame.JOYBALLMOTION")
        if event.type == pygame.JOYBUTTONDOWN:            
            if event.button == 0:
                print("pygame.JOYBUTTONDOWN btn 0")
            if event.button == 2:
                print("pygame.JOYBUTTONDOWN btn 2")
            if event.button == 3:
                print("pygame.JOYBUTTONDOWN btn 3")
            if event.button == 1:
                print("pygame.JOYBUTTONDOWN btn 1")
                
        if event.type == pygame.JOYBUTTONUP:
            print("pygame.JOYBUTTONUP")


    pressed = pygame.key.get_pressed()
    if pressed[pygame.K_LEFT]:
        x -= vel
    if pressed[pygame.K_RIGHT]:
        x += vel
    if pressed[pygame.K_UP]:
        y -= vel
    if pressed[pygame.K_DOWN]:
        y += vel
        
    #screen.fill((0, 0, 0))
    #pygame.draw.rect(screen, (0, 128, 255), pygame.Rect(x, y, 60, 60))
    #pygame.display.flip() 
    clock.tick(60)

pygame.quit()

#_joystick = pygame.joystick.Joystick(0)
#_joystick.init()
#print(pygame.joystick.get_count())
#print( _joystick.get_init())
#print( _joystick.get_id())
#print( _joystick.get_name())
#print( _joystick.get_numaxes())
#print( _joystick.get_numballs())
#print( _joystick.get_numbuttons())
#print( _joystick.get_numhats())
#print( _joystick.get_axis(0))
