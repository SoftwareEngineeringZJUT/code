function getStyle({ draggableStyle, virtualStyle, isDragging }) {
    // If you don't want any spacing between your items
    // then you could just return this.
    // I do a little bit of magic to have some nice visual space
    // between the row items
    const combined = {
      ...virtualStyle,
      ...draggableStyle,
    };
  
    // Being lazy: this is defined in our css file
    const grid = 15;
  
    // when dragging we want to use the draggable style for placement, otherwise use the virtual style
    const result = {
      ...combined,
      height: 50,
      left: isDragging ? combined.left : combined.left + grid,
      width: isDragging
        ? draggableStyle.width
        : `calc(${combined.width} - ${grid * 2}px)`,
      marginBottom: 25,
    };
  
    return result;
  }
  
  export default function Item({ provided, item, style, isDragging }) {
    return (
      <div
        {...provided.draggableProps}
        {...provided.dragHandleProps}
        ref={provided.innerRef}
        style={getStyle({
          draggableStyle: provided.draggableProps.style,
          virtualStyle: style,
          isDragging,
        })}
        className={`item ${isDragging ? 'is-dragging' : ''}`}
      >
        {item.text}
      </div>
    );
  }
  