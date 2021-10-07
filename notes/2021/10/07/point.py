import math


class Point:
    def __init__(self, x: int = 0, y: int = 0):
        self.x = x
        self.y = y

    def distance_to(self, q) -> float:
        return math.hypot(self.x - q.x, self.y - q.y)
    
    def reflect_across_x(self):
        return Point(self.x, -self.y)
    
    def reflect_across_y(self):
        return Point(-self.x, self.y)
    
    def reflect_across_yx(self):
        return Point(self.y, self.x)

    def __repr__(self):

        return f"<Point x={self.x}, y={self.y}>"
    
    def __eq__(self, o):
        if type(o) != Point:
            return False
        if o is self:
            return True
        return self.x == o.x and self.y == o.y


if __name__ == "__main__":

    point = Point(3, 4)
    point_2 = Point()
    print(point.distance_to(point_2))
