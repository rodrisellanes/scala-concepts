def loop: Int = loop

def byName(x: Int, y: => Int) = if (true) x else y
byName(2, loop)

def byValue(x: Int, y: Int) = if(true) x else y
//byValue(2, loop)