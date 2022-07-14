import React from 'react'
import Axios from 'axios'

const API = {
  async callAPI({ url, method, data,headers }) {
    return await Axios({
      url,
      method,
      data,
      headers
    })
  }
}

export default API