/*************************************************************************************/
// Block A
ipcMain.on('mt::ask-for-image-auto-path', (e, { pathname, src, id }) => {
  const win = BrowserWindow.fromWebContents(e.sender)
  if (!src || typeof src !== 'string') {
    win.webContents.send(`mt::response-of-image-path-${id}`, [])
    return
  }
  if (src.endsWith('/') || src.endsWith('\\') || src.endsWith('.')) {
    return win.webContents.send(`mt::response-of-image-path-${id}`, [])
  }
  const fullPath = path.isAbsolute(src) ? src : path.join(path.dirname(pathname), src)
  const dir = path.dirname(fullPath)
  const searchKey = path.basename(fullPath)
  searchFilesAndDir(dir, searchKey)
    .then(files => {
      return win.webContents.send(`mt::response-of-image-path-${id}`, files)
    })
    .catch(err => {
      log.error(err)
      return win.webContents.send(`mt::response-of-image-path-${id}`, [])
    })
})
// Block B
const filesHandler = (files, directory, key) => {
  const IMAGE_REG = new RegExp('(' + IMAGE_EXTENSIONS.join('|') + ')$', 'i')
  const onlyDirAndImage = files
    .map(file => {
      const fullPath = path.join(directory, file)
      let type = ''
      if (isDirectory(fullPath)) {
        type = 'directory'
      } else if (isFile(fullPath) && IMAGE_REG.test(file)) {
        type = 'image'
      }
      return {
        file,
        type
      }
    })
    .filter(({
      file,
      type
    }) => {
      if (BLACK_LIST.includes(file)) return false
      return type === 'directory' || type === 'image'
    })
  IMAGE_PATH.set(directory, onlyDirAndImage)
  if (key !== undefined) {
    return filter(onlyDirAndImage, key, {
      key: 'file'
    })
  }
}
/*************************************************************************************/
// Block A'
ipcMain.on('mt::ask-for-image-auto-path', (e, { pathname, src, id }) => {
  const win = BrowserWindow.fromWebContents(e.sender)
  if (!src || typeof src !== 'string') {
    win.webContents.send(`mt::response-of-image-path-${id}`, [])
    return
  }
  if (src.endsWith('/') || src.endsWith('\\') || src.endsWith('.')) {
    return win.webContents.send(`mt::response-of-image-path-${id}`, [])
  }
  const fullPath = path.isAbsolute(src) ? src : path.join(path.dirname(pathname), src)
  const dir = path.dirname(fullPath)
  const searchKey = path.basename(fullPath)
  searchFilesAndDir(dir, searchKey)
    .then(files => {
      return win.webContents.send(`mt::response-of-image-path-${id}`, files)
    })
    .catch(err => {
      log.error(err)
      return win.webContents.send(`mt::response-of-image-path-${id}`, [])
    })
})
console.log("This acts as a block spliter!");
// Block B'
const filesHandler = (files, directory, key) => {
  const IMAGE_REG = new RegExp('(' + IMAGE_EXTENSIONS.join('|') + ')$', 'i')
  const onlyDirAndImage = files
    .map(file => {
      const fullPath = path.join(directory, file)
      let type = ''
      if (isDirectory(fullPath)) {
        type = 'directory'
      } else if (isFile(fullPath) && IMAGE_REG.test(file)) {
        type = 'image'
      }
      return {
        file,
        type
      }
    })
    .filter(({
      file,
      type
    }) => {
      if (BLACK_LIST.includes(file)) return false
      return type === 'directory' || type === 'image'
    })
  IMAGE_PATH.set(directory, onlyDirAndImage)
  if (key !== undefined) {
    return filter(onlyDirAndImage, key, {
      key: 'file'
    })
  }
}
