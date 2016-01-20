import numpy as np
import cv2
#from matplotlib import pyplot as plt

# Load an color image in grayscale
img = cv2.imread('starWars.jpg',0)
kernel = np.ones((5,5),np.uint8)
kernel2 = cv2.getStructuringElement(cv2.MORPH_CROSS,(25,25))
#erosion = cv2.erode(img,kernel,iterations = 1)



tophat = cv2.morphologyEx(img, cv2.MORPH_TOPHAT, kernel)
#cv2.namedWindow('tophat', cv2.WINDOW_NORMAL)
#cv2.imshow('img',tophat)
#cv2.waitKey(0)
#cv2.destroyAllWindows()


erosion = cv2.erode(img,kernel,iterations = 1)
#cv2.namedWindow('erosion', cv2.WINDOW_NORMAL)
#cv2.imshow('img', erosion)
#cv2.waitKey(0)
#cv2.destroyAllWindows()


dilation = cv2.dilate(img,kernel,iterations = 1)
#cv2.namedWindow('dilation', cv2.WINDOW_NORMAL)
#cv2.imshow('img', dilation)
#cv2.waitKey(0)
#cv2.destroyAllWindows()


opening = cv2.morphologyEx(img, cv2.MORPH_OPEN, kernel)
#cv2.namedWindow('opening', cv2.WINDOW_NORMAL)
#cv2.imshow('img', opening)
#cv2.waitKey(0)
#cv2.destroyAllWindows()



closing = cv2.morphologyEx(img, cv2.MORPH_CLOSE, kernel)
#cv2.namedWindow('opening', cv2.WINDOW_NORMAL)
#cv2.imshow('img', opening)
#cv2.waitKey(0)
#cv2.destroyAllWindows()


gradient = cv2.morphologyEx(img, cv2.MORPH_GRADIENT, kernel)
#cv2.namedWindow('gradient', cv2.WINDOW_NORMAL)
#cv2.imshow('img', gradient)
#cv2.waitKey(0)
#cv2.destroyAllWindows()


blackhat = cv2.morphologyEx(img, cv2.MORPH_BLACKHAT, kernel2)
cv2.namedWindow('blackhat', cv2.WINDOW_NORMAL)
cv2.imshow('img', blackhat)
cv2.waitKey(0)
cv2.destroyAllWindows()