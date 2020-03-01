package application.utility;

import application.audio.AudioLoader;
import application.screens.controls.CustomButton;
import application.screens.controls.CustomToggleButton;
import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

import static application.Application.*;

public class Cloner {

    // TODO : Test these : Pane, Label, Button and one of the Shapes :
    static public Object clone(Object toCopy, boolean copyEvents, boolean copyChildren) {
        if (toCopy instanceof Pane) {
            Pane copiedObject = new Pane();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneParent((Parent)toCopy, copiedObject, copyEvents, copyChildren);
            cloneRegion((Region)toCopy, copiedObject);

            return copiedObject;
        }
        else if (toCopy instanceof Rectangle) {
            Rectangle copiedObject = new Rectangle();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Rectangle obj = (Rectangle)toCopy;

            copiedObject.setWidth(obj.getWidth());
            copiedObject.setHeight(obj.getHeight());
            copiedObject.setArcWidth(obj.getArcWidth());
            copiedObject.setArcHeight(obj.getArcHeight());
            copiedObject.setX(obj.getX());
            copiedObject.setY(obj.getY());

            return copiedObject;
        }
        else if (toCopy instanceof SVGPath) {
            SVGPath copiedObject = new SVGPath();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            SVGPath obj = (SVGPath)toCopy;

            copiedObject.setContent(obj.getContent());
            copiedObject.setFillRule(obj.getFillRule());

            return copiedObject;
        }
        else if (toCopy instanceof Path) {
            Path copiedObject = new Path();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Path obj = (Path)toCopy;

            copiedObject.getElements().addAll(obj.getElements());
            copiedObject.setFillRule(obj.getFillRule());

            return copiedObject;
        }
        else if (toCopy instanceof Polygon || toCopy instanceof Polyline) {
            Shape copiedObject;
            if (toCopy instanceof Polygon) {
                copiedObject = new Polygon();
                ((Polygon)copiedObject).getPoints().addAll(((Polygon)toCopy).getPoints());
            }
            else {
                copiedObject = new Polyline();
                ((Polyline)copiedObject).getPoints().addAll(((Polyline)toCopy).getPoints());
            }
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);

            return copiedObject;
        }
        else if (toCopy instanceof Arc) {
            Arc copiedObject = new Arc();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Arc obj = (Arc)toCopy;

            copiedObject.setCenterX(obj.getCenterX());
            copiedObject.setCenterY(obj.getCenterY());
            copiedObject.setLength(obj.getLength());
            copiedObject.setRadiusX(obj.getRadiusX());
            copiedObject.setRadiusY(obj.getRadiusY());
            copiedObject.setStartAngle(obj.getStartAngle());
            copiedObject.setType(obj.getType());

            return copiedObject;
        }
        else if (toCopy instanceof Circle) {
            Circle copiedObject = new Circle();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Circle obj = (Circle)toCopy;

            copiedObject.setCenterX(obj.getCenterX());
            copiedObject.setCenterY(obj.getCenterY());
            copiedObject.setRadius(obj.getRadius());

            return copiedObject;
        }
        else if (toCopy instanceof Text) {
            Text copiedObject = new Text();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Text obj = (Text)toCopy;

            copiedObject.setBoundsType(obj.getBoundsType());
            copiedObject.setFont(obj.getFont());
            copiedObject.setFontSmoothingType(obj.getFontSmoothingType());
            copiedObject.setLineSpacing(obj.getLineSpacing());
            copiedObject.setStrikethrough(obj.isStrikethrough());
            copiedObject.setTextAlignment(obj.getTextAlignment());
            copiedObject.setText(obj.getText());
            copiedObject.setUnderline(obj.isUnderline());
            copiedObject.setWrappingWidth(obj.getWrappingWidth());
            copiedObject.setX(obj.getX());
            copiedObject.setY(obj.getY());

            return copiedObject;
        }
        else if (toCopy instanceof CubicCurve) {
            CubicCurve copiedObject = new CubicCurve();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            CubicCurve obj = (CubicCurve)toCopy;

            copiedObject.setControlX1(obj.getControlX1());
            copiedObject.setControlX2(obj.getControlX2());
            copiedObject.setControlY1(obj.getControlY1());
            copiedObject.setControlY2(obj.getControlY2());
            copiedObject.setEndX(obj.getEndX());
            copiedObject.setEndY(obj.getEndY());
            copiedObject.setStartX(obj.getStartX());
            copiedObject.setStartY(obj.getStartY());

            return copiedObject;
        }
        else if (toCopy instanceof Ellipse) {
            Ellipse copiedObject = new Ellipse();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Ellipse obj = (Ellipse)toCopy;

            copiedObject.setCenterX(obj.getCenterX());
            copiedObject.setCenterY(obj.getCenterY());
            copiedObject.setRadiusX(obj.getRadiusX());
            copiedObject.setRadiusY(obj.getRadiusY());

            return copiedObject;
        }
        else if (toCopy instanceof Line) {
            Line copiedObject = new Line();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            Line obj = (Line)toCopy;

            copiedObject.setStartX(obj.getStartX());
            copiedObject.setStartY(obj.getStartY());
            copiedObject.setEndX(obj.getEndX());
            copiedObject.setEndY(obj.getEndY());

            return copiedObject;
        }
        else if (toCopy instanceof QuadCurve) {
            QuadCurve copiedObject = new QuadCurve();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);
            QuadCurve obj = (QuadCurve)toCopy;

            copiedObject.setControlX(obj.getControlX());
            copiedObject.setControlY(obj.getControlY());
            copiedObject.setStartX(obj.getStartX());
            copiedObject.setStartY(obj.getStartY());
            copiedObject.setEndX(obj.getEndX());
            copiedObject.setEndY(obj.getEndY());

            return copiedObject;
        }
        else if (toCopy instanceof CustomButton) {
            CustomButton copiedObject = new CustomButton();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneParent((Parent)toCopy, copiedObject, copyEvents, false);
            cloneRegion((Region)toCopy, copiedObject);
            cloneControl((Control)toCopy, copiedObject);
            cloneLabeled((Labeled)toCopy, copiedObject);
            cloneButtonBase((ButtonBase)toCopy, copiedObject);
            CustomButton obj = (CustomButton)toCopy;

            copiedObject.setCancelButton(obj.isCancelButton());
            copiedObject.setDefaultButton(obj.isDefaultButton());
            copiedObject.originScaleX = obj.originScaleX;
            copiedObject.originScaleY = obj.originScaleY;

            return copiedObject;
        }
        else if (toCopy instanceof Button) {
            Button copiedObject = new Button();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneParent((Parent)toCopy, copiedObject, copyEvents, false);
            cloneRegion((Region)toCopy, copiedObject);
            cloneControl((Control)toCopy, copiedObject);
            cloneLabeled((Labeled)toCopy, copiedObject);
            cloneButtonBase((ButtonBase)toCopy, copiedObject);
            Button obj = (Button)toCopy;

            copiedObject.setCancelButton(obj.isCancelButton());
            copiedObject.setDefaultButton(obj.isDefaultButton());

            return copiedObject;
        }
        else if (toCopy instanceof CustomToggleButton) {
            CustomToggleButton copiedObject = new CustomToggleButton();
            System.out.println("Copying a button!");
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneParent((Parent)toCopy, copiedObject, copyEvents, false);
            cloneRegion((Region)toCopy, copiedObject);
            cloneControl((Control)toCopy, copiedObject);
            cloneLabeled((Labeled)toCopy, copiedObject);
            cloneButtonBase((ButtonBase)toCopy, copiedObject);
            CustomToggleButton obj = (CustomToggleButton)toCopy;

            copiedObject.originScaleX = obj.originScaleX;
            copiedObject.originScaleY = obj.originScaleY;

            return copiedObject;
        }
        else if (toCopy instanceof Label) {
            Label copiedObject = new Label();
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneParent((Parent)toCopy, copiedObject, copyEvents, false);
            cloneRegion((Region)toCopy, copiedObject);
            cloneControl((Control)toCopy, copiedObject);
            cloneLabeled((Labeled)toCopy, copiedObject);

            copiedObject.setLabelFor(((Label)toCopy).getLabelFor());

            return copiedObject;
        }
        else if (toCopy instanceof Shape) {
            // TODO : test this copy of shape :
            Shape copiedObject = new Shape() {};
            cloneNode((Node)toCopy, copiedObject, copyEvents);
            cloneShape((Shape) toCopy, copiedObject);

            return copiedObject;
        }
        else if (toCopy instanceof FadeTransition) {
            FadeTransition copiedObject = new FadeTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            FadeTransition obj = (FadeTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setFromValue(obj.getFromValue());
            copiedObject.setByValue(obj.getByValue());
            copiedObject.setToValue(obj.getToValue());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else if (toCopy instanceof FillTransition) {
            FillTransition copiedObject = new FillTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            FillTransition obj = (FillTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setFromValue(obj.getFromValue());
            copiedObject.setToValue(obj.getToValue());
            copiedObject.setShape(obj.getShape());

            return copiedObject;
        }
        else if (toCopy instanceof ParallelTransition) {
            ParallelTransition copiedObject = new ParallelTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            ParallelTransition obj = (ParallelTransition)toCopy;

            copiedObject.getChildren().addAll(obj.getChildren());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else if (toCopy instanceof PathTransition) {
            PathTransition copiedObject = new PathTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            PathTransition obj = (PathTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setPath(obj.getPath());
            copiedObject.setOrientation(obj.getOrientation());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else if (toCopy instanceof PauseTransition) {
            PauseTransition copiedObject = new PauseTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            PauseTransition obj = (PauseTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());

            return copiedObject;
        }
        else if (toCopy instanceof RotateTransition) {
            RotateTransition copiedObject = new RotateTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            RotateTransition obj = (RotateTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setToAngle(obj.getToAngle());
            copiedObject.setByAngle(obj.getByAngle());
            copiedObject.setFromAngle(obj.getFromAngle());
            copiedObject.setAxis(obj.getAxis());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else if (toCopy instanceof ScaleTransition) {
            ScaleTransition copiedObject = new ScaleTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            ScaleTransition obj = (ScaleTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setFromX(obj.getFromX());
            copiedObject.setFromY(obj.getFromY());
            copiedObject.setFromZ(obj.getFromZ());
            copiedObject.setByX(obj.getByX());
            copiedObject.setByY(obj.getByY());
            copiedObject.setByZ(obj.getByZ());
            copiedObject.setToX(obj.getToX());
            copiedObject.setToY(obj.getToY());
            copiedObject.setToZ(obj.getToZ());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else if (toCopy instanceof SequentialTransition) {
            SequentialTransition copiedObject = new SequentialTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            SequentialTransition obj = (SequentialTransition)toCopy;

            copiedObject.getChildren().addAll(obj.getChildren());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else if (toCopy instanceof StrokeTransition) {
            StrokeTransition copiedObject = new StrokeTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            StrokeTransition obj = (StrokeTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setFromValue(obj.getFromValue());
            copiedObject.setToValue(obj.getToValue());
            copiedObject.setShape(obj.getShape());

            return copiedObject;
        }
        else if (toCopy instanceof TranslateTransition) {
            TranslateTransition copiedObject = new TranslateTransition();
            cloneAnimation((Animation)toCopy, copiedObject);
            TranslateTransition obj = (TranslateTransition)toCopy;

            copiedObject.setDuration(obj.getDuration());
            copiedObject.setToX(obj.getToX());
            copiedObject.setToY(obj.getToY());
            copiedObject.setToZ(obj.getToZ());
            copiedObject.setByX(obj.getByX());
            copiedObject.setByY(obj.getByY());
            copiedObject.setByZ(obj.getByZ());
            copiedObject.setFromX(obj.getFromX());
            copiedObject.setFromY(obj.getFromY());
            copiedObject.setFromZ(obj.getFromZ());
            copiedObject.setNode(obj.getNode());

            return copiedObject;
        }
        else {
            System.out.println("This object's class"+toCopy.getClass().getName()+" is not supported for cloning");

            return null;
        }
    }

    private static void cloneParent(Parent source, Parent target, boolean copyEvents, boolean copyChildren) {

        target.getStylesheets().addAll(source.getStylesheets());
        if (copyChildren) {
            ObservableList<Node> children = ((Pane) target).getChildren();
            for (Node child : children) {
                // NOTE : copyChildren is always true :
                ((Pane) target).getChildren().add((Node) clone(child, copyEvents, true));
            }
        }
    }

    private static void cloneRegion(Region source, Region target) {

        if (source.getBackground() != null) {
            target.setBackground(source.getBackground());
        }
        if (source.getBorder() != null) {
            target.setBorder(source.getBorder());
        }
        target.setCacheShape(source.isCacheShape());
        target.setCenterShape(source.isCenterShape());
        target.setMinWidth(source.getMinWidth());
        target.setMaxWidth(source.getMaxWidth());
        target.setMinHeight(source.getMinHeight());
        target.setMaxHeight(source.getMaxHeight());
        target.setPrefWidth(source.getPrefWidth());
        target.setPrefHeight(source.getPrefHeight());
        target.setOpaqueInsets(source.getOpaqueInsets());
        if (source.getPadding() != null && source.getPadding() != Insets.EMPTY) {
            target.setPadding(source.getPadding());
        }
        target.setScaleShape(source.isScaleShape());
        if (source.getShape() != null) {
            target.setShape((Shape)clone(source.getShape(), false, false));
        }
        target.setSnapToPixel(source.isSnapToPixel());

    }

    private static void cloneShape(Shape source, Shape target) {

        target.setFill(source.getFill());
        target.setSmooth(source.isSmooth());
        target.setStroke(source.getStroke());
        target.setStrokeDashOffset(source.getStrokeDashOffset());
        target.setStrokeLineCap(source.getStrokeLineCap());
        target.setStrokeLineJoin(source.getStrokeLineJoin());
        target.setStrokeType(source.getStrokeType());
        target.setStrokeWidth(source.getStrokeWidth());

    }

    private static void cloneButtonBase(ButtonBase source, ButtonBase target) {

        if (source.isArmed()) {
            target.arm();
        }
        else {
            target.disarm();
        }

    }

    private static void cloneControl(Control source, Control target) {

        target.setContextMenu(source.getContextMenu());
        target.setTooltip(source.getTooltip());
        target.setSkin(source.getSkin());

    }

    private static void cloneAnimation(Animation source, Animation target) {

        target.setAutoReverse(source.isAutoReverse());
        target.setCycleCount(source.getCycleCount());
        target.setDelay(source.getDelay());
        target.setRate(source.getRate());
        target.setOnFinished(source.getOnFinished());

    }

    private static void cloneLabeled(Labeled source, Labeled target) {

        target.setAlignment(source.getAlignment());
        target.setContentDisplay(source.getContentDisplay());
        target.setEllipsisString(source.getEllipsisString());
        target.setFont(source.getFont());
        target.setText(source.getText());
        target.setGraphic(source.getGraphic());
        target.setGraphicTextGap(source.getGraphicTextGap());
        target.setLineSpacing(source.getLineSpacing());
        target.setMnemonicParsing(source.isMnemonicParsing());
        target.setTextAlignment(source.getTextAlignment());
        target.setTextOverrun(source.getTextOverrun());
        target.setTextFill(source.getTextFill());
        target.setUnderline(source.isUnderline());
        target.setWrapText(source.isWrapText());

    }

    private static void cloneNode(Node source, Node target, boolean copyEvents) {

        target.setCursor(source.getCursor());
        target.setId(source.getId());
        target.setLayoutX(source.getLayoutX());
        target.setLayoutY(source.getLayoutY());
        target.setScaleX(source.getScaleX());
        target.setScaleY(source.getScaleY());
        target.setScaleZ(source.getScaleZ());
        target.setAccessibleHelp(source.getAccessibleHelp());
        target.setAccessibleRole(source.getAccessibleRole());
        target.setAccessibleRoleDescription(source.getAccessibleRoleDescription());
        target.setAccessibleText(source.getAccessibleText());
        target.setFocusTraversable(source.isFocusTraversable());
        target.setBlendMode(source.getBlendMode());
        target.setCache(source.isCache());
        target.setCacheHint(source.getCacheHint());
        target.setClip(source.getClip());
        target.setDepthTest(source.getDepthTest());
        target.setDisable(source.isDisable());
        target.setEffect(source.getEffect());
        target.setInputMethodRequests(source.getInputMethodRequests());
        target.setManaged(source.isManaged());
        target.setMouseTransparent(source.isMouseTransparent());
        target.setNodeOrientation(source.getNodeOrientation());
        target.setOpacity(source.getOpacity());
        target.setPickOnBounds(source.isPickOnBounds());
        target.setRotate(source.getRotate());
        target.setRotationAxis(source.getRotationAxis());
        target.setStyle(source.getStyle());
        target.setTranslateX(source.getTranslateX());
        target.setTranslateY(source.getTranslateY());
        target.setTranslateZ(source.getTranslateZ());
        target.setUserData(source.getUserData());
        target.setViewOrder(source.getViewOrder());
        target.setVisible(source.isVisible());

        if (copyEvents) {
            target.setOnContextMenuRequested(source.getOnContextMenuRequested());
            target.setOnDragDetected(source.getOnDragDetected());
            target.setOnDragDone(source.getOnDragDone());
            target.setOnDragDropped(source.getOnDragDropped());
            target.setOnDragEntered(source.getOnDragEntered());
            target.setOnDragExited(source.getOnDragExited());
            target.setOnDragOver(source.getOnDragOver());
            target.setOnInputMethodTextChanged(source.getOnInputMethodTextChanged());
            target.setOnKeyPressed(source.getOnKeyPressed());
            target.setOnKeyTyped(source.getOnKeyTyped());
            target.setOnKeyReleased(source.getOnKeyReleased());
            target.setOnMouseClicked(source.getOnMouseClicked());
            target.setOnMouseReleased(source.getOnMouseReleased());
            target.setOnMousePressed(source.getOnMousePressed());
            target.setOnMouseMoved(source.getOnMouseMoved());
            target.setOnMouseExited(source.getOnMouseExited());
            target.setOnMouseEntered(source.getOnMouseEntered());
            target.setOnMouseDragReleased(source.getOnMouseDragReleased());
            target.setOnMouseDragOver(source.getOnMouseDragOver());
            target.setOnMouseDragged(source.getOnMouseDragged());
            target.setOnMouseDragExited(source.getOnMouseDragExited());
            target.setOnMouseDragEntered(source.getOnMouseDragEntered());
            target.setOnRotate(source.getOnRotate());
            target.setOnRotationStarted(source.getOnRotationStarted());
            target.setOnRotationFinished(source.getOnRotationFinished());
            target.setOnScroll(source.getOnScroll());
            target.setOnScrollStarted(source.getOnScrollStarted());
            target.setOnScrollFinished(source.getOnScrollFinished());
            target.setOnTouchMoved(source.getOnTouchMoved());
            target.setOnTouchPressed(source.getOnTouchPressed());
            target.setOnTouchReleased(source.getOnTouchReleased());
            target.setOnTouchStationary(source.getOnTouchStationary());
            target.setOnSwipeUp(source.getOnSwipeUp());
            target.setOnSwipeDown(source.getOnSwipeDown());
            target.setOnSwipeRight(source.getOnSwipeRight());
            target.setOnSwipeLeft(source.getOnSwipeLeft());
            target.setOnZoom(source.getOnZoom());
            target.setOnZoomStarted(source.getOnZoomStarted());
            target.setOnZoomFinished(source.getOnZoomFinished());
        }

    }

}
