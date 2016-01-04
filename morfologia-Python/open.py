import numpy as np
import cv2
from matplotlib import pyplot as plt

# Load an color image in grayscale
img = cv2.imread('starWars.jpg',0)
kernel = np.ones((5,5),np.uint8)
#erosion = cv2.erode(img,kernel,iterations = 1)

tophat = cv2.morphologyEx(img, cv2.MORPH_TOPHAT, kernel)
cv2.namedWindow('tophat', cv2.WINDOW_NORMAL)
cv2.imshow('img',tophat)
cv2.waitKey(0)
cv2.destroyAllWindows()
