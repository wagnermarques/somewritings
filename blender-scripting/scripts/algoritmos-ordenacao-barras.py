import bpy

v=[]
m=[]
t=[]
def defineBarras(): 
    "Define shape do cubo" 
    #vertsGen1 = [(x1,0,0) ,(0,5,0) ,(5,5,0) ,(5,0,0) ,(0,0,5)  ,(0,5,5)  ,(5,5,5)  ,(5,0,5)]        
    verts1 = [(0,0,0) ,(0,5,0) ,(5,5,0) ,(5,0,0) ,(0,0,5)  ,(0,5,5)  ,(5,5,5)  ,(5,0,5)]
    verts2 = [(10,0,0),(10,5,0),(15,5,0),(15,0,0),(10,0,10),(10,5,10),(15,5,10),(15,0,10)]
    verts3 = [(20,0,0),(20,5,0),(25,5,0),(25,0,0),(20,0,15),(20,5,15),(25,5,15),(25,0,15)]
    verts4 = [(30,0,0),(30,5,0),(35,5,0),(35,0,0),(30,0,20),(30,5,20),(35,5,20),(35,0,20)]
    verts5 = [(40,0,0),(40,5,0),(45,5,0),(45,0,0),(40,0,25),(40,5,25),(45,5,25),(45,0,25)]

    faces = [(0,1,2,3), (4,5,6,7), (0,4,5,1), (1,5,6,2), (2,6,7,3), (3,7,4,0)]
 
    #Define mesh and object
    meshCube1 = bpy.data.meshes.new("Cube")
    meshCube2 = bpy.data.meshes.new("Cube")
    meshCube3 = bpy.data.meshes.new("Cube")
    meshCube4 = bpy.data.meshes.new("Cube")
    meshCube5 = bpy.data.meshes.new("Cube")
    obj1 = bpy.data.objects.new("Cube1", meshCube1)
    obj2 = bpy.data.objects.new("Cube2", meshCube2)
    obj3 = bpy.data.objects.new("Cube3", meshCube3)
    obj4 = bpy.data.objects.new("Cube4", meshCube4)    
    obj5 = bpy.data.objects.new("Cube5", meshCube5)

    v.append(obj1)
    v.append(obj2)
    v.append(obj3)
    v.append(obj4)
    v.append(obj5)
    #bpy.context.scene.objects.link(object)
    #AttributeError: 'bpy_prop_collection' object has no attribute 'link'
    
    bpy.context.collection.objects.link(obj1)
    bpy.context.collection.objects.link(obj2)
    bpy.context.collection.objects.link(obj3)
    bpy.context.collection.objects.link(obj4)
    bpy.context.collection.objects.link(obj5)
    
    #Set location and scene of object
    #obj.location = 0.0.0
    
 
    #Create mesh
    meshCube1.from_pydata(verts1,[],faces)
    meshCube2.from_pydata(verts2,[],faces)
    meshCube3.from_pydata(verts3,[],faces)
    meshCube4.from_pydata(verts4,[],faces)
    meshCube5.from_pydata(verts5,[],faces)

    meshCube1.update(calc_edges=True)
    meshCube2.update(calc_edges=True)
    meshCube3.update(calc_edges=True)
    meshCube5.update(calc_edges=True)
    m.append(meshCube1)
    m.append(meshCube2)
    m.append(meshCube3)
    m.append(meshCube4)
    m.append(meshCube5)


    obj1Txt_coX=obj1.data.vertices[1].co.x
    bpy.ops.object.text_add(location=(obj1Txt_coX, 0, 1), rotation=(0, 0, 0))
    obj1Txt=bpy.context.object
    obj1Txt.data.name = "txtObj1"
    obj1Txt.data.size = 5
    obj1Txt.data.body = str(obj1.data.vertices[5].co.z)
    bpy.ops.transform.rotate(
        value=1.78973, 
        orient_axis='X', orient_type='LOCAL', 
        orient_matrix=((1, 0, 0), (0, 1, 0), (0, 0, 1)), 
        orient_matrix_type='LOCAL', 
        constraint_axis=(True, False, False), 
        mirror=True, 
        use_proportional_edit=False, 
        proportional_edit_falloff='SMOOTH', 
        proportional_size=1, 
        use_proportional_connected=False, 
        use_proportional_projected=False)


    obj2Txt_coX=obj2.data.vertices[1].co.x
    bpy.ops.object.text_add(location=(obj2Txt_coX, 0, 1), rotation=(0, 0, 0))
    obj2Txt=bpy.context.object
    obj1Txt.data.name = "txtObj2"
    obj2Txt.data.size = 5
    obj2Txt.data.body = str(obj2.data.vertices[5].co.z)
    bpy.ops.transform.rotate(
        value=1.78973, 
        orient_axis='X', orient_type='LOCAL', 
        orient_matrix=((1, 0, 0), (0, 1, 0), (0, 0, 1)), 
        orient_matrix_type='LOCAL', 
        constraint_axis=(True, False, False), 
        mirror=True, 
        use_proportional_edit=False, 
        proportional_edit_falloff='SMOOTH', 
        proportional_size=1, 
        use_proportional_connected=False, 
        use_proportional_projected=False)


    obj3Txt_coX=obj3.data.vertices[1].co.x
    bpy.ops.object.text_add(location=(obj3Txt_coX, 0, 1), rotation=(0, 0, 0))
    obj3Txt=bpy.context.object
    obj1Txt.data.name = "txtObj3"
    obj3Txt.data.size = 5
    obj3Txt.data.body = str(obj3.data.vertices[5].co.z)
    bpy.ops.transform.rotate(
        value=1.78973, 
        orient_axis='X', orient_type='LOCAL', 
        orient_matrix=((1, 0, 0), (0, 1, 0), (0, 0, 1)), 
        orient_matrix_type='LOCAL', 
        constraint_axis=(True, False, False), 
        mirror=True, 
        use_proportional_edit=False, 
        proportional_edit_falloff='SMOOTH', 
        proportional_size=1, 
        use_proportional_connected=False, 
        use_proportional_projected=False)



    obj4Txt_coX=obj4.data.vertices[1].co.x
    bpy.ops.object.text_add(location=(obj4Txt_coX, 0, 1), rotation=(0, 0, 0))
    obj4Txt=bpy.context.object
    obj1Txt.data.name = "txtObj4"
    obj4Txt.data.size = 5
    obj4Txt.data.body = str(obj4.data.vertices[5].co.z)
    bpy.ops.transform.rotate(
        value=1.78973, 
        orient_axis='X', orient_type='LOCAL', 
        orient_matrix=((1, 0, 0), (0, 1, 0), (0, 0, 1)), 
        orient_matrix_type='LOCAL', 
        constraint_axis=(True, False, False), 
        mirror=True, 
        use_proportional_edit=False, 
        proportional_edit_falloff='SMOOTH', 
        proportional_size=1, 
        use_proportional_connected=False, 
        use_proportional_projected=False)


    obj5Txt_coX=obj5.data.vertices[1].co.x
    bpy.ops.object.text_add(location=(obj5Txt_coX, 0, 1), rotation=(0, 0, 0))
    obj5Txt=bpy.context.object
    obj1Txt.data.name = "txtObj5"
    obj5Txt.data.size = 5
    obj5Txt.data.body = str(obj5.data.vertices[5].co.z)
    bpy.ops.transform.rotate(
        value=1.78973, 
        orient_axis='X', orient_type='LOCAL', 
        orient_matrix=((1, 0, 0), (0, 1, 0), (0, 0, 1)), 
        orient_matrix_type='LOCAL', 
        constraint_axis=(True, False, False), 
        mirror=True, 
        use_proportional_edit=False, 
        proportional_edit_falloff='SMOOTH', 
        proportional_size=1, 
        use_proportional_connected=False, 
        use_proportional_projected=False)
    t.append(obj1Txt)
    t.append(obj2Txt)
    t.append(obj3Txt)
    t.append(obj4Txt)
    t.append(obj5Txt)
    
    

def ls():
    "Lista todos os objetos da cena"
    for o in bpy.data.objects:
        print("Object Name: " +o.name+ ", Type: "+o.type)
        #if(o.type == "MESH"):
        #    print("Object Name:" + o.name + " type:" + o.type)
        #    showMeshVertices(o)

def limpaCena():
    "Limpa todos os objetos MESH da cena"
    #for f in bpy.data.fonts:
    #    bpy.data.fonts.remove(f)
    #Isso aqui tb funciona    
    #for m in bpy.data.meshes:
    #    bpy.data.meshes.remove(m)
    for o in bpy.context.scene.objects:
        if o.type == 'MESH':
            o.select_set(True)
        if o.type == 'FONT':
            o.select_set(True)   
    else:
        o.select_set(False)
    bpy.ops.object.delete()
                

def trocaPosicao(o1,t1,o2,t2):    
    "Muda para posicao toP2 onde toP2 can be (0,0,0) like vector"
    t1.location=(o2.data.vertices[0].co.x, 0, 1)
    t2.location=(o1.data.vertices[0].co.x, 0, 1)
    #print(dir(t1.data))
    for i in range(0,8):
        vert1 = o1.data.vertices[i]
        vert2 = o2.data.vertices[i]
        temp_x = vert1.co.x
        temp_y = vert1.co.y
        vert1.co.x = vert2.co.x
        vert1.co.y = vert2.co.y
        vert2.co.x = temp_x
        vert2.co.y = temp_y

        #a = a + 1
        #for vert2 in o2.data.vertices:
            #b = b + 1
            #if( a == b ):
                #print(str(vert1.co) +" "+ str(vert2.co))                
        #m1.update(calc_edges=True)
    #x=o.data.vertices.co.x
    #y=o.data.vertices.co.y
    #z=o.data.vertices.co.z
    #o.data.vertices.co = (-10,-10,-10)
    #o.update(calc_edges=True)        
    #print(x)
    #print(y)
    #print(z)

def showMeshVertices(o):
    if(o.type == "MESH"):
        print("- - -" + o.name + "-vertices...")
        for verts in o.data.vertices:
            print(verts.co.x)
            print(verts.co.y)
            print(verts.co.z)
            
    

limpaCena()
defineBarras()
ls()
trocaPosicao(v[1],t[1],v[4],t[4])
#insertMeshes()
#bpy.ops.mesh.primitive_monkey_add(location=(0,0,0))
#for o in bpy.data.objects:
#    print(o.name)